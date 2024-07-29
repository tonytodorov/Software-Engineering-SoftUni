function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const getData = document.querySelectorAll('tbody tr')
      
      const matchRows = getMatchElements()  
      console.log(matchRows); 
   
      
      const searchedData = document.getElementById('searchField').value

      

   }
}
