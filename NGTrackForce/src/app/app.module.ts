///
//  DEPENDENCIES
///

import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule, JsonpModule } from '@angular/http';


///
//  COMPONENTS
///

import { AppComponent } from './app.component';
import { AssociateListComponent } from './components/associate-list/associate-list.component';
import { BatchListComponent } from './components/batch-list/batch-list.component';
import { ClientMappedComponent } from './components/client-mapped/client-mapped.component';
import { CreateUserComponent } from './components/create-user/create-user.component';
import { LoginComponent } from './components/login/login.component';
import { ClientListComponent } from './components/client-list/client-list.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';

///
//  SERVICES
///

import { AssociateService } from './services/associates-service/associates-service';
import { ClientService } from './services/clients-service/clients-service';
import { ClientMappedService } from './services/client-mapped-service/client-mapped-service.service';
import { AuthenticationService } from './services/authentication/authentication.service';

///
//  CONSTANTS
///

import { appRoutes } from './routing/routes';
import { SkillsetComponent } from './components/skillset/skillset.component';




@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    SkillsetComponent,
=======
    NavbarComponent,
    HomeComponent,
>>>>>>> 670628564e05cf452de71ad090b384cd2a2c3ae2
    AssociateListComponent,
    BatchListComponent,
    ClientMappedComponent,
    ClientListComponent,
    LoginComponent,
    CreateUserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [AssociateService, ClientService, ClientMappedService, AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
