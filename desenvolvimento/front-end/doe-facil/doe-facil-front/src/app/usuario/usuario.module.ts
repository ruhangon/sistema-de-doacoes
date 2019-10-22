import { FormsModule } from '@angular/forms';
import {ConfirmDialogModule} from 'primeng/confirmdialog';

import { UsuarioService } from './usuario.service';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CadastroComponent } from './cadastro/cadastro.component';

import {InputTextModule} from 'primeng/inputtext';

@NgModule({
  declarations: [CadastroComponent],
  imports: [
    CommonModule,
    InputTextModule,
    FormsModule,
    ConfirmDialogModule,
    RouterModule
  ],
  exports: [
    CadastroComponent
  ],
  providers: [
    UsuarioService,
  ]
})
export class UsuarioModule { }
