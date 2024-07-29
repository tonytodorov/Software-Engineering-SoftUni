function search() {
   const textFieldValue = document.getElementById('searchText').value
   const towns = document.getElementById('towns').innerText
   const items = document.getElementsByTagName('li')

   const townsArray = towns.split('\n')

   let countMatches = 0

   for (let i = 0; i < townsArray.length; i++) {

      items[i].style.fontWeight = 'normal'
      items[i].style.textDecoration = 'none'

      if(townsArray[i].includes(textFieldValue)) {
         countMatches++
         items[i].style.fontWeight = 'bold'
         items[i].style.textDecoration = 'underline'
      }
   }

   const result = document.getElementById('result')
   result.innerHTML = `${countMatches} matches found`
}
