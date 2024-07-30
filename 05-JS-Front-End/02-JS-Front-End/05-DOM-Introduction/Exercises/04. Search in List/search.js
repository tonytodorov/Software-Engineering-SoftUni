function search() {
   const townsListElement = Array.from(document.getElementById('towns').children)
   const inputElement = document.getElementById('searchText')
   const resultElement = document.getElementById('result')
   
   let count = 0

   for (let i = 0; i < townsListElement.length; i++) {
      const element = townsListElement[i].innerText;

      townsListElement[i].style.textDecoration = 'none'
      townsListElement[i].style.fontWeight = 'normal'

      if (element.includes(inputElement.value)) {
         count++
         townsListElement[i].style.textDecoration = 'underline'
         townsListElement[i].style.fontWeight = 'bold'
      }
   }

   inputElement.value = ''
   resultElement.textContent = `${count} matches found`
}
