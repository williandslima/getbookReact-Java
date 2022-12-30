import React, {useState, useEffect} from 'react';
import { useNavigate, Link, useParams} from 'react-router-dom';
import './styles.css';

import api from '../../services/api'

import logoImage from '../../assets/padlockOff.png'

export default function NewPostagem() {

    
    const [id, setId] = useState(null);
    const [nome, setNome] = useState('');
    const [descricao, setDescricao] = useState('');

    const {postagemId} = useParams();

    const recebeToken = localStorage.getItem('accessToken');

    const navigate = useNavigate();

    async function loadPostagem() {
        try {
            const response = await api.get(`postagens/${postagemId}`,{
                headers:{
                    Authorization: recebeToken
                }
            })
            setId (response.data.id)
            setNome(response.data.nome)
            setDescricao(response.data.descricao)
            
        } catch (err) {
            alert('Erro ao carregar! Tente novamente');
            navigate('/postagens');
        }
    }

    useEffect(() =>{
        
    if (postagemId === '0') return; 
        else loadPostagem();
    }, 
    [postagemId]);


    async function salvarOuAtualizar(e){
        e.preventDefault();

        const data = {
                nome,
                descricao
        };
        try {
            if (postagemId === '0') {
                await api.post('postagens', data, {
                    headers: {
                        Authorization: recebeToken
                    }
                });
            alert('Cadastro Salvo')

            } else {
                data.id = id;
                await api.put('postagens', data, {
                    headers: {
                        Authorization: recebeToken
                    }
                });
            alert('Cadastro atualizado')
            }

            navigate('/postagens');
        } catch (err) {
            alert('Erro ao salvar a postagem')
        }
    };
    return (
        <div className="new-book-container">
             <div className="content">
                <section className="form">
                <img src={logoImage} alt="Erudio"/>
                <h1>{postagemId === '0' ? 'Adicionar nova ' : 'Atualizar nova' } Postagem </h1>
                <p> Entre com as informacoes e clique em {postagemId === '0' ? "Adicionar" : "Atualizar" }  postagem! </p>
                    <Link className="back-link" to="/postagens">
                        Voltar para postagens
                    </Link>
                </section>
                <form onSubmit={salvarOuAtualizar}>
                     <input
                        type="text" placeholder="Nome" name="Nome"
                        value={nome}
                        onChange={e => setNome(e.target.value)}
                    />
                    <input
                        type="text" placeholder="Descricao do livro"
                        value={descricao}
                        onChange={e => setDescricao(e.target.value)}
                    />                  
                    <button className="button" type="submit">{postagemId === '0' ? 'Adicionar Postagem' : 'Atualizar Postagem' } </button>
                </form>

            </div>

        </div>
    )

}