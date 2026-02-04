import { addFavorite, getFavorites } from "../../favorites";

interface Props {
    id: string;
    title: string;
    imageUrl: string | undefined;
    publisher: string;
    year: number;
    isbn: string;
    authors: Array<String>;
}

// Este componente deve retornar os dados do livro em um card
export default function Card(props: Props) {
    return (
        <div className="bookCard">
            <img src={props.imageUrl} />
            <p>{props.title}</p>
            <p>{props.authors}</p>
            <button onClick={() => {addFavorite(props.id), console.log(getFavorites())}}>{"⭐"}</button>
        </div>
    );
}