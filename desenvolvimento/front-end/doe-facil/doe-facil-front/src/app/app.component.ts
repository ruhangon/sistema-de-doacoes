import { Component } from '@angular/core';
import { UsuarioService } from './usuario/usuario.service';
import { Usuario } from './usuario/model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'DOE-FÁCIL';

  logado:Usuario

  constructor(private service: UsuarioService){}

  login(){
    this.service.buscarUsuarioPorCodigo(1).then((dados)=>{ this.logado=dados});
  }


}
