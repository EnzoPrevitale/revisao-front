export function getFavorites(): string[] {
  return JSON.parse(localStorage.getItem("favorites") ?? "[]")
}

export function addFavorite(id: string) {
  const favorites = getFavorites()

  if (!favorites.includes(id)) {
    favorites.push(id)
    localStorage.setItem("favorites", JSON.stringify(favorites))
  }
}
