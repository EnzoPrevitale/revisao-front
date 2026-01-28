interface Props {
    title: string;
    imageUrl: string;
    author: string;
    publisher: string;
    year: number;
    isbn: number;
}

// Este componente deve retornar os dados do livro em um card
export default function Card(props: Props) {
    return (
        <div className="bookCard">
            <img src={props.imageUrl} />
            <p>{props.title}</p>
            <p>{props.author}</p>
            <button>{"<3"}</button>
        </div>
    );
}