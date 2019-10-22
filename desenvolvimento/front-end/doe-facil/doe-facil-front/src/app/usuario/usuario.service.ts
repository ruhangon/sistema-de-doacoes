import { Usuario } from './model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  usuariosURL = 'http://localhost:8090/usuarios';
  urlFiltro;

  constructor(private http: HttpClient) { }

  pesquisar(filtro: any): Promise<any> {
    if(filtro.nome){
      this.urlFiltro = 'http://localhost:8090/usuarios/filtro?nome='+filtro.nome;
    }else{
      this.urlFiltro = 'http://localhost:8090/usuarios';
    }

    return this.http.get<any>(this.urlFiltro).toPromise();
  }

  adicionar(usuario: Usuario): Promise<any>{
    return this.http.post(this.usuariosURL, usuario)
    .toPromise();
  }

  alterar(usuario: Usuario): Promise<any>{
    return this.http.put(this.usuariosURL+'/'+usuario.id, usuario)
    .toPromise();
  }

  buscarPorCodigo(codigo: number): Promise<Usuario> {
    return this.http.get<Usuario>(this.usuariosURL+'/'+codigo).toPromise();
  }

}

