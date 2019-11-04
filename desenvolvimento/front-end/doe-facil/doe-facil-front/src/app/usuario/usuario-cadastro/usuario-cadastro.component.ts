import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/usuario/usuario.service';
import { MessageService } from 'primeng/api';
import { Usuario } from 'src/app/usuario/model';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-usuario-cadastro',
  templateUrl: './usuario-cadastro.component.html',
  styleUrls: ['./usuario-cadastro.component.css']
})
export class UsuarioCadastroComponent implements OnInit {

  usuario = new Usuario();
  estados=[
    {label:'Acre', value:'Acre'},
    {label:'Alagoas', value:'Alagoas'},
    {label:'Amapá', value:'Amapá'},
    {label:'Amazonas', value:'Amazonas'},
    {label:'Bahia', value:'Bahia'},
    {label:'Ceará', value:'Ceará'},
    {label:'Distrito Federal', value:'Distrito Federal'},
    {label:'Espírito Santo', value:'Espírito Santo'},
    {label:'Goiás', value:'Goiás'},
    {label:'Maranhão', value:'Maranhão'},
    {label:'Mato Grosso', value:'Mato Grosso'},
    {label:'Mato Grosso do Sul', value:'Mato Grosso do Sul'},
    {label:'Minas Gerais', value:'Minas Gerais'},
    {label:'Pará', value:'Pará'},
    {label:'Paraíba', value:'Paraíba'},
    {label:'Paraná', value:'Paraná'},
        {label:'Pernambuco', value:'Pernambuco'},
    {label:'Piauí', value:'Piauí'},
    {label:'Rio de Janeiro', value:'Rio de Janeiro'},
    {label:'Rio Grande do Norte', value:'Rio Grande do Norte'},
    {label:'Rio Grande do Sul', value:'Rio Grande do Sul'},
    {label:'Rondônia', value:'Rondônia'},
    {label:'Roraima', value:'Roraima'},
    {label:'Santa Catarina', value:'Santa Catarina'},
    {label:'São Paulo', value:'São Paulo'},
    {label:'Sergipe', value:'Sergipe'},
    {label:'Tocantins', value:'Tocantins'},
  ];

  constructor(
    private service:UsuarioService,
    private messageService: MessageService,
    private rota: ActivatedRoute
  ) { }

  ngOnInit() {
  }

  cadastrar(form: FormControl) {

    this.service.cadastrarUsuario(this.usuario)
      .then(() => {
        this.messageService.add({ severity: 'success', detail: 'Usuario ' + this.usuario.nomeCompleto + ' Cadastrado' });
        form.reset();
      });
  }
}
