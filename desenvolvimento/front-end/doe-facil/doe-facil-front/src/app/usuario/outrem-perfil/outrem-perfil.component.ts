import { doacaoService } from 'src/app/doacao/doacaoService.service';
import { Component, OnInit } from '@angular/core';
import { Usuario, Notificacao } from 'src/app/model';
import { ServicosService } from 'src/app/servicos.service';
import { MessageService, DialogService, ConfirmationService } from 'primeng/api';
import { ActivatedRoute, Router } from '@angular/router';
import { Doacao } from 'src/app/doacao/modelos';

@Component({
  selector: 'app-outrem-perfil',
  templateUrl: './outrem-perfil.component.html',
  styleUrls: ['./outrem-perfil.component.css']
})
export class OutremPerfilComponent implements OnInit {

  outrem = new Usuario();

  doacoes:Doacao[];

  mostrar: boolean = false;

  notificacao : Notificacao = new Notificacao();

  constructor(private service: ServicosService,
    private messageService: MessageService,
    private rota: ActivatedRoute,
    private rotaprogramatica:Router,
    private doaService: doacaoService,
    private conf: ConfirmationService,
   ) { }

  ngOnInit() {
    const codigoUsuario = this.rota.snapshot.params['id'];
    if(codigoUsuario){this.carregarUsuario(codigoUsuario);
    }

  }

  carregarUsuario(id:number){
    if(id==this.service.logado.idUsuario){
       this.rotaprogramatica.navigate(['/usuario/meuperfil']);
    }else{
    this.service.buscarUsuarioPorCodigo(id).then((data) => {this.outrem = data;});
    this.service.buscarDoacoesFeitas(id).then((feitas) => {this.outrem.feitas=feitas});
    this.service.buscarDoacoesRecebidas(id).then((recebidas) => {this.outrem.recebidas=recebidas});
    this.service.buscarDoacoesFeitasDisponiveis(this.service.logado.idUsuario).then((dados) => {this.doacoes=dados});
    }

  }

  mostrarDoacoes(){
    this.service.buscarDoacoesFeitasDisponiveis(this.service.logado.idUsuario).then((dados) => {this.doacoes=dados});
    this.mostrar = true;
  }

  confirmarEnvio(doacao:Doacao){
    this.conf.confirm({
      message: 'Tem certeza que deseja enviar sua Doação ' +doacao.nome+ ' para ' + this.outrem.nomeCompleto+'?',
      accept: () => {
        this.enviarDoacao(doacao);
      }
    });
  }

  enviarDoacao(doacao:Doacao){
    doacao.status='Finalizada';
    doacao.recebedor=this.outrem;
    this.notificacao.conteudo=this.service.logado.nomeCompleto+' enviou a doação '+ doacao.nome+ ' para você <3'
    this.notificacao.notificado.idUsuario=this.outrem.idUsuario;
    this.notificacao.notificador.idUsuario=this.service.logado.idUsuario;
    this.service.adicionarNotificacao(this.notificacao);
    this.doaService.alterar(doacao);
    this.messageService.add({severity:'success', summary:'Doação', detail: doacao.nome+' Enviada com Sucesso'});
    this.mostrar=false;
    this.service.buscarDoacoesRecebidas(this.outrem.idUsuario).then((recebidas) => {this.outrem.recebidas=recebidas});
  }

}
