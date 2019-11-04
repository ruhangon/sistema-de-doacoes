import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { FormControl } from '@angular/forms';
import { doacaoService } from '../doacao.service';
import { Doacao} from '../model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-doacao-cadastro',
  templateUrl: './doacao-cadastro.component.html',
  styleUrls: ['./doacao-cadastro.component.css']
})
export class DoacaoCadastroComponent implements OnInit {

nova:Doacao=new Doacao();

categorias=[
  {label:'Brinquedos', value:'Brinquedos'},
  {label:'Eletrônicos', value:'Eletrônicos'},
  {label:'Esportes', value:'Esportes'},
  {label:'Livros', value:'Livros'},
  {label:'Roupas', value:'Roupas'},
  {label:'Saúde', value:'Saúde'},
  {label:'Outros', value:'Outros'},
];

metodos=[
  {label:'Doador Paga o Frete', value:'Doador Paga o Frete'},
  {label:'Recebedor Paga o Frete', value:'Recebedor Paga o Frete'},
  {label:'A Combinar', value:'A Combinar'},
];


  constructor(private service: doacaoService,
    private messageService: MessageService,
    private rotaprogramatica:Router) { }

  ngOnInit() {

  }

  cadastrar(form: FormControl) {

    this.nova.doador.idUsuario=1;

    this.service.adicionarDoacao(this.nova)
      .then(() => {
        this.messageService.add({ severity: 'success', detail: 'Doação ' + this.nova.nome + ' Cadastrada' });
        form.reset();
      });

      //this.rotaprogramatica.navigate(['/doacoes']);
  }
}
