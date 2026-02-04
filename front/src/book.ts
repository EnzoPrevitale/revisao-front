export type Book = {
    id: string;
    title: string;
    imageUrl?: string | undefined;
    publisher: string;
    year: number;
    isbn: string;
    authors: string[];
}

