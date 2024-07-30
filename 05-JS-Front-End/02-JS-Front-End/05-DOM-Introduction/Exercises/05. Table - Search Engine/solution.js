function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() { 
      debugger
      const trElements = document.querySelectorAll('table.container tbody tr')
      const inputElement = document.getElementById('searchField')
      

      for (const currentRow of trElements) {
         const element = currentRow.children;
      
         currentRow.className = ''
         
         for (const currentChild of element) {
            const data = currentChild.textContent;
            
            if (data.includes(inputElement.value)) {
               currentRow.className = 'select'
               break
            }
         }
      }
      
      inputElement.value = ''
   }
}
