import { Notificacao } from './../../model';
import { Component, OnInit } from '@angular/core';
import { doacaoService } from '../doacaoService.service';
import { Doacao } from '../modelos';
import { MessageService, ConfirmationService } from 'primeng/api';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicosService } from 'src/app/servicos.service';

@Component({
  selector: 'app-doacao-detalhe',
  templateUrl: './doacao-detalhe.component.html',
  styleUrls: ['./doacao-detalhe.component.css']
})
export class DoacaoDetalheComponent implements OnInit {

  notificacao = new Notificacao();
  doacao = new Doacao();
  gosteiClicado:boolean=false;
  naogosteiClicado:boolean=false;
  solicitada:boolean=false;

  constructor(private service: doacaoService,
    private messageService: MessageService,
    private rota: ActivatedRoute,
    private rotaprogramatica:Router,
    private service2: ServicosService,
    private conf: ConfirmationService,) { }

  ngOnInit() {
    const codigoDoacao = this.rota.snapshot.params['id'];
    if(codigoDoacao){
      this.carregarDoacao(codigoDoacao);
    }
  }

  carregarDoacao(id:number){
    this.service.buscarPorCodigo(id).then((data) => {this.doacao = data; } );
  }

  gostei(){
    this.gosteiClicado=true;
    this.doacao.votosPositivos++;
    this.doacao.doador.votosPositivosUsuario++;

    if(this.naogosteiClicado){
      this.naogosteiClicado=false
      this.doacao.votosNegativos--;
      this.doacao.doador.votosNegativosUsuario--;
    }

    this.service.alterar(this.doacao);
    this.service.atualizarUsuario(this.doacao.doador);

  }

  naogostei(){
    this.naogosteiClicado=true
    this.doacao.votosNegativos++;
    this.doacao.doador.votosNegativosUsuario++;

    if(this.gosteiClicado){
       this.gosteiClicado=false
       this.doacao.votosPositivos--;
       this.doacao.doador.votosPositivosUsuario--;
      }

      this.service.alterar(this.doacao);
      this.service.atualizarUsuario(this.doacao.doador);


  }

  confirmarSolicitacao(){
    this.conf.confirm({
      message: 'Enviar Pedido de Solicitação da Doação?',
      accept: () => {
        this.enviarSolicitacao();
      }
    });
  }

  enviarSolicitacao(){
    this.notificacao.conteudo='Usuário fez o pedido de Solicitação de sua doação '+ this.doacao.nome
    this.notificacao.notificador.idUsuario=this.service2.logado.idUsuario;
    this.notificacao.notificado.idUsuario=this.doacao.doador.idUsuario;

    this.service2.adicionarNotificacao(this.notificacao) .then(()=>{
      this.messageService.add({severity:'success', summary:'Notificação Enviada!'});
    });

    this.solicitada=true;
  }

}
