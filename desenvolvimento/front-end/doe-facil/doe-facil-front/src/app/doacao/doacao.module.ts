import { DropdownModule } from 'primeng/dropdown';
import { PanelModule } from 'primeng/panel';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DoacaoPesquisaComponent } from './doacao-pesquisa/doacao-pesquisa.component';
import { RouterModule} from '@angular/router';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {TooltipModule} from 'primeng/tooltip';
import { FormsModule } from '@angular/forms';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import { DataViewModule } from 'primeng/dataview';
import { ToastModule } from 'primeng/toast';
import {PasswordModule} from 'primeng/password';
import {DialogModule} from 'primeng/dialog';
import { DoacaoCadastroComponent } from './doacao-cadastro/doacao-cadastro.component';
import { MessageService } from 'primeng/api';
import { doacaoService } from './doacaoService.service';
import { ServicosService } from '../servicos.service';
import { DoacaoDetalheComponent } from './doacao-detalhe/doacao-detalhe.component';


@NgModule({
  declarations: [DoacaoPesquisaComponent, DoacaoCadastroComponent, DoacaoDetalheComponent],
  imports: [
    CommonModule,
    DataViewModule,
    InputTextModule,
    ButtonModule,
    TooltipModule,
    ToastModule,
    FormsModule,
    ConfirmDialogModule,
    RouterModule,
    PanelModule,
    DropdownModule,
    InputTextModule,
    PasswordModule,
    DialogModule
  ],
  providers:  [
    ServicosService,
    doacaoService,
    MessageService
  ],
  exports:[
    DoacaoCadastroComponent
  ]
})
export class DoacaoModule { }
