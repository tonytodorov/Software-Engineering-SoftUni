function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);
    
    function onClick() { 
        const trElements = document.querySelectorAll('table.container tbody tr')
        const inputElement = document.getElementById('searchField')
        
        for (const currentRow of trElements) {
            const element = currentRow.children;
            
            currentRow.className = ''
            // If we have more than one class, we need to use classList to remove concrete class
            // currentRow.classList.remove('select')
            
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
