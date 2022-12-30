import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { FiPower, FiEdit, FiTrash2 } from 'react-icons/fi'

import api from '../../services/api'

import './styles.css';

import logoImage from '../../assets/padlockOff.png'

export default function Postagens(){

    const [postagens, setPostagens] = useState([]);
    const [page, setPage] = useState(0);

    const username = localStorage.getItem('usuario');
    const accessToken = localStorage.getItem('accessToken');

    const navigate = useNavigate();

    async function logout() {
        localStorage.clear();
        navigate('/');
    }

    async function deletePostagem(id) {
        try {
            await api.delete(`postagens/${id}`,{
                headers: {
                    Authorization: accessToken
                }
            })
            setPostagens(postagens.filter(postagem => postagem.id !== id))
        } catch (err) {
            alert("Nao foi possivel deletar, tente novamente")
        }
    }

    async function editarPostagem(id) {
        try {
            navigate(`/postagem/new/${id}`)
        } catch (err) {
            alert("Nao foi possivel editar, tente novamente")
        }
    }

    async function todasPostagens (){
        const response = await api.get('postagens',{
            headers: {
                Authorization: accessToken
            },
            params: {
                page: page,
                size: 4,
                direction: 'asc'
            }
        });
            setPostagens([ ...postagens, ...response.data._embedded.devPostagemVOList])
            setPage(page + 1);
        
    }
    
    useEffect(() => {
        todasPostagens()
    }, []);
    
    return (
        <div className="book-container">
            <header>
                <img src={logoImage} alt="Erudio"/>
                <span>Bem vindo, <strong>{username.toUpperCase()}</strong>!</span>
                <Link className="button" to="/postagem/new/0">Add nova Postagem </Link>
                <button onClick={logout} type="button">
                    <FiPower size={18} color="#251FC5" />
                </button>
            </header>

            <h1>Postagens salvas</h1>
            <ul>
                {postagens.map(postagem => (
                                        <li key={postagem.id} >
                                            <strong>Titulo:</strong>
                                            <p>{postagem.nome}</p>
                                            <strong>Descricao:</strong>
                                            <p>{postagem.descricao}</p>
                                        
                                            <button onClick={() => editarPostagem(postagem.id)} type="button">
                                            <FiEdit size={20} color="#251FC5"/>
                                            </button>
                                            <button onClick={() => deletePostagem(postagem.id)} type="button">
                                                <FiTrash2 size={20} color="#251FC5"/>
                                            </button>
                                        </li>
                ))}
            </ul>
            <button className="button" onClick={todasPostagens} type="button">Carregar mais</button>
        </div>
    );
}