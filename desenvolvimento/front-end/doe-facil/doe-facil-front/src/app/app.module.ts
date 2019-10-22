import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CadastroComponent } from './usuario/cadastro/cadastro.component';

import { AppComponent } from './app.component';

import {Routes, RouterModule} from '@angular/router';

const rotas: Routes = [
  {path: '', redirectTo:'cadastro', pathMatch:'full'},
  {path: 'cadastro', component: CadastroComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    CadastroComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(rotas)
  ],
  providers: [  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
