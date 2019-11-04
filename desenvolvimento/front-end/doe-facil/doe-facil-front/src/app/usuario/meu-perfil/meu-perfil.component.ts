import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { UsuarioService } from 'src/app/usuario/usuario.service';
import { Usuario } from 'src/app/usuario/model';

@Component({
  selector: 'app-meu-perfil',
  templateUrl: './meu-perfil.component.html',
  styleUrls: ['./meu-perfil.component.css']
})
export class MeuPerfilComponent implements OnInit {

   eu:Usuario=new Usuario();


  constructor(private service:UsuarioService,
  private messageService: MessageService,) { }

  ngOnInit() {
  this.service.buscarUsuarioPorCodigo(1).then((dados)=>{ this.eu=dados});
  this.service.buscarDoacoesFeitas(1).then((feitas)=>{this.eu.feitas=feitas});
  this.service.buscarDoacoesRecebidas(1).then((recebidas)=>{ this.eu.recebidas=recebidas});
  }

}
