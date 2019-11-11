import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ServicosService } from 'src/app/servicos.service';
import { MessageService } from 'primeng/api';
import { Usuario } from 'src/app/model';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-usuario-cadastro',
  templateUrl: './usuario-cadastro.component.html',
  styleUrls: ['./usuario-cadastro.component.css']
})
export class UsuarioCadastroComponent implements OnInit {

  usuario = new Usuario();
  senha2:string;
  senhaAtual:string;

  mudandoSenha:boolean=false;
  senhaNova:string;
  senhaNova2:string;

  uploadedFiles: any[] = [];

  estados=[
    {label:'Santa Catarina', value:'Santa Catarina'},
    {label:'São Paulo', value:'São Paulo'},
    {label:'Paraná', value:'Paraná'},
    {label:'Sergipe', value:'Sergipe'},
  ];

  constructor(
    private service:ServicosService,
    private messageService: MessageService,
    private rotaprogramatica:Router
  ) { }

  ngOnInit() {
    if(this.service.logado!=null){
      this.usuario=this.service.Usuariologado();
    }
  }

  cadastrar(form: FormControl) {
    if(this.usuario.senha==this.senha2){

      this.service.cadastrarUsuario(this.usuario).then(() => {
        this.messageService.add({ severity: 'success', detail: 'Usuario ' + this.usuario.nomeCompleto + ' Cadastrado' });
      }).then( ()=>{
        this.service.autenticar(this.usuario.senha)})

    }else{
      this.messageService.add({ severity: 'error', detail: 'Senhas diferentes' });
    }

  }

  alterar(form: FormControl) {

    if(this.usuario.senha==this.senhaAtual){
      if(this.mudandoSenha){
        if(this.senhaNova==this.senhaNova2){
          this.usuario.senha=this.senhaNova;
          this.service.editarUsuario(this.usuario)
          .then( ()=>{
          this.messageService.add({severity:'success', summary:'Edição', detail:'Usuário '+this.usuario.nomeCompleto+' alterado'});
          form.reset();
          });
          this.rotaprogramatica.navigate(['/usuario/meuperfil']);
        }else{
          this.messageService.add({ severity: 'error', detail: 'Senhas novas não coincidem' });
        }
      }else{
        this.service.editarUsuario(this.usuario)
        .then( ()=>{
        this.messageService.add({severity:'success', summary:'Edição', detail:'Usuário '+this.usuario.nomeCompleto+' alterado'});
        form.reset();
        });
        this.rotaprogramatica.navigate(['/usuario/meuperfil']);
      }
    }else{
      this.messageService.add({ severity: 'error', detail: 'Senha incorreta' });
    }
 }






  salvar(form: FormControl) {
    if(this.editando){
      this.alterar(form);
    }else{
      this.cadastrar(form);
    }
  }

  get editando(){
    return Boolean(this.usuario.idUsuario);
  }

  mudarSenha() {
    this.mudandoSenha = !this.mudandoSenha;
}

 // onUpload(event) {
//
  //  <h3>Foto</h3>
    //      <p-fileUpload mode="basic" name="demo[]" accept="image/*"
      //     maxFileSize="1000000" (click)="onUpload($event)"></p-fileUpload>
        //  </div>
        //this.usuario.imgUsuario=event.file;

    //this.messageService.add({severity: 'info', summary: 'Imagem Enviada', detail: ''});
//}

}
