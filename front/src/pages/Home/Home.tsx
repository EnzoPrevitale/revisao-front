import Card from "../../components/Card/Card"
import api from "../../api"
import { useEffect, useState } from "react"
import type { Book } from "../../book"
import { getFavorites } from "../../favorites";

export default function Home() {

    const [ response, setResponse ] = useState<Array<Book>>([]);
    const [favorites, setFavorites] = useState(0);

    useEffect(() => {
        api.get("/books")
            .then(d => setResponse(d.data))
            .catch(e => console.error('Erro', e));
    }, []);

    useEffect(() => {
        setFavorites(getFavorites().length);
    }, [getFavorites()]);

    // Retorna cards com todos os livros
    return (
        <section id="home">
            <h1>Catálogo de Livros</h1>
            <h2>Favoritados: {favorites}</h2>
            <div className="books">
                {
                    response.map(b => 
                        <Card key={b.id} id={b.id} title={b.title} imageUrl={b.imageUrl} publisher={b.publisher} year={b.year} isbn={b.isbn} authors={b.authors} />
                    )
                }
            </div>
        </section>
    )
}