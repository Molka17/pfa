import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { ToastrModule } from 'ngx-toastr';
import { AuthService } from './services/auth.service';
import { NgxWebstorageModule } from 'ngx-webstorage';
import { ProjectService } from './services/project.service';
import { AllProjectsComponent } from './pages/AllProjects/AllProjects.component';
import { ModalComponent } from './pages/modal/modal.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    AuthLayoutComponent,
    AllProjectsComponent,
    ModalComponent
    
  ],
  imports: [
    BrowserAnimationsModule,
    HttpClientModule,
    ComponentsModule,
    NgbModule,
    RouterModule,
    AppRoutingModule,
    ToastrModule.forRoot(),
    NgxWebstorageModule.forRoot()
  ],
  providers: [AuthService, ProjectService],
  bootstrap: [AppComponent]
})
export class AppModule { }
