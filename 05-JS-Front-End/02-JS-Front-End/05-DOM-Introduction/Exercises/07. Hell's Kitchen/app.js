function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick () {
      let text = document.querySelector('textarea').value
      
      // text = text.replace(/[\[\]-]/g, '')
      // let arr = text.split(', ')

      const extractData = (data) => {
         const result = [];
       
         data.forEach(entry => {
           const [restaurant, details] = entry.split(' - ');
       
           const detailsArray = details.split(',').map(s => s.trim()).filter(Boolean);
       
           detailsArray.forEach(detail => {
             const parts = detail.split(' ');
             const salary = parts.pop(); 
             const name = parts.join(' '); 
       
             if (name && salary) {
               result.push({ restaurant, person: name, salary: parseInt(salary, 10) });
             }
           });
         });
       
         return result;
       };
       
      
       extractData(text)

   }
}
