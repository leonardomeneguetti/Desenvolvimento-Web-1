var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
	return new bootstrap.Tooltip(tooltipTriggerEl)
});

var myModal = document.getElementById('myModal');
var bsModal = new bootstrap.Modal(document.getElementById('myModal'));
myModal.addEventListener('show.bs.modal', function(event) {
	// Botão que acionou o modal
	var button = event.relatedTarget;
	// Extrair informações dos atributos data-bs-*
	var id = button.getAttribute('data-bs-id');

	// Atualizar o conteúdo do modal
	var modalTitle = myModal.querySelector('.modal-title');
	var modalButton = myModal.querySelector('.modal-footer #delete');

	modalTitle.textContent = 'Exclusão da Atividade ' + id;
	modalButton.addEventListener('click', function(){
		deleteActivity(button,id);
		bsModal.hide();
	})
})

function deleteActivity(button, id){
	var row = button.parentNode.parentNode.parentNode; // button->span->td->tr 
	const url = "ControllerServlet?action=deleteActivity&activity-id="+id;

	// Solicitação GET.
	fetch(url)
	// Tratamento do sucesso
	.then(response =>{
		return response.json(); // converter para JSON
	})
	.then(data =>{
	   	if(data){
			row.parentNode.removeChild(row); // remover linha da tabela
		}
	})
	.catch(error => console.log('Erro de solicitação', error)); // lidar com os erros por catch
}