import { useState } from 'react'
import './App.css'

function App() {
  const [formulario, setFormulario] = useState({
    tipo: 'prestacao-servico',
    contratante: '',
    contratado: '',
    valor: '',
    prazo: '',
    descricao: ''
  })
  const [contrato, setContrato] = useState('')
  const [carregando, setCarregando] = useState(false)

  function handleChange(e) {
    setFormulario({ ...formulario, [e.target.name]: e.target.value })
  }

  async function gerarContrato() {
    setCarregando(true)
    try {
      const resposta = await fetch('http://localhost:8080/contratos/gerar', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formulario)
      })
      const texto = await resposta.text()
      setContrato(texto)
    } catch (erro) {
      setContrato('Erro ao conectar com o servidor.')
    }
    setCarregando(false)
  }

  return (
    <div className="container">
      <h1>Gerador de Contratos com IA</h1>

      <div className="formulario">
        <div className="campo">
          <label>Tipo de contrato</label>
          <select name="tipo" value={formulario.tipo} onChange={handleChange}>
            <option value="prestacao-servico">Prestação de Serviço</option>
            <option value="aluguel">Aluguel</option>
            <option value="compra-venda">Compra e Venda</option>
            <option value="parceria">Parceria Comercial</option>
          </select>
        </div>

        <div className="campo">
          <label>Nome do contratante</label>
          <input name="contratante" value={formulario.contratante}
            onChange={handleChange} placeholder="Nome completo" />
        </div>

        <div className="campo">
          <label>Nome do contratado</label>
          <input name="contratado" value={formulario.contratado}
            onChange={handleChange} placeholder="Nome completo" />
        </div>

        <div className="campo">
          <label>Valor (R$)</label>
          <input name="valor" value={formulario.valor}
            onChange={handleChange} placeholder="Ex: 5000" />
        </div>

        <div className="campo">
          <label>Prazo</label>
          <input name="prazo" value={formulario.prazo}
            onChange={handleChange} placeholder="Ex: 3 meses" />
        </div>

        <div className="campo">
          <label>Descrição do serviço</label>
          <textarea name="descricao" value={formulario.descricao}
            onChange={handleChange} placeholder="Descreva o que será realizado..." />
        </div>

        <button onClick={gerarContrato} disabled={carregando}>
          {carregando ? 'Gerando contrato...' : 'Gerar Contrato com IA'}
        </button>
      </div>

      {contrato && (
        <div className="resultado">
          <h2>Contrato Gerado</h2>
          <pre>{contrato}</pre>
        </div>
      )}
    </div>
  )
}

export default App