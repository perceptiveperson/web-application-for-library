/**
 * 
 */
var id;
var nome;
var lista = new list();

function autorSelecionado(){
	
var textoOptionSelecionado = document.getElementById("idAutores").options.remove(document.getElementById("idAutores").selectedIndex);

var codigoOptionSelecionado = document.getElementById("idAutores").options[document.getElementById("idAutores").selectedIndex].value;


setCodigo(codigoOptionSelecionado);
setNome(textoOptionSelecionado);

getCodigo();
}

function setCodigo(opt){
	
	lista.add(opt);
	
}

function getCodigo(){
	
	return alert(lista);
}

function setNome(opt){
	
	nome = opt;
}

function getNome(){
	
	return alert(nome);
}


function recarrega() {
	  var p = document.getElementById('Foo');
	  var filhos = p.childNodes;
	  for( i = filhos.length - 1; i >= 0; i-- ) {
	    if( filhos[i].tagName == 'LI' ) {
	      p.removeChild( filhos[i] );
	    }
	  }

	  var li = document.createElement('li');
	  li.innerHTML = 'seis';
	  p.appendChild(li);

	  var li = document.createElement('li');
	  li.innerHTML = 'sete';
	  p.appendChild(li);
	}