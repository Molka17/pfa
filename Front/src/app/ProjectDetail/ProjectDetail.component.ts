import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Project } from '../shared/project';
import { ProjectService } from '../services/project.service';
import { ModalComponent } from '../pages/modal/modal.component';
@Component({
  selector: 'app-project-detail',
  templateUrl: './projectDetail.component.html',
  styleUrls: ['./projectDetail.component.scss']
})
export class ProjectDetailComponent implements OnInit {

  project: Project;
  projectId :number;
  showModal = false;

  ouvrirModal() {
    console.log('Formulaire ouvert avec succès');
    this.showModal = true;
    console.log('après le true');

  }

  fermerModal() {
    this.showModal = false;
  }

  confirmer() {
    // Ajouter ici le code pour confirmer la soumission du formulaire
    console.log('Formulaire soumis avec succès');
  }
  constructor(
    private route: ActivatedRoute,
    private projectService: ProjectService
  ) { }

  ngOnInit() {
    this.project = new Project();

    this.projectId=this.route.snapshot.params['id'];
    // this.route.queryParams.subscribe(params => {
    //   const projectId = Number(params['id']); // Parse the string value to a number
    //   this.projectService.getProject(projectId).subscribe(project => {
    //     this.project = project;
    //   });
    // });
    this.projectService.getProject(this.projectId).subscribe(data => {
      this.project = data;
    })
  
  }
  

}
