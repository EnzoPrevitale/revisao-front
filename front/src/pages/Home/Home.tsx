import Card from "../../components/Card/Card"

export default function Home() {

    const mock = [
        {
            title: "Assim Falava Zaratustra",
            imageUrl: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1iA8TYp9TXppLSsnjCs-EUNDv7DyucIt0-Q&s",
            author: "Friedrich Nietzche",
            publisher: "Veríssimo",
            year: 1883,
            isbn: 9893895031142
        },
        
    ]

    // Retorna cards com todos os livros
    return (
        <section id="home">
            {mock.map((book) => <Card title={book.title} imageUrl={book.imageUrl} author={book.author} publisher={book.publisher} year={book.year} isbn={book.isbn} />)}
        </section>
    )
}