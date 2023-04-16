import { Component, OnInit } from '@angular/core';
import Chart from 'chart.js';
import { ProjectService } from 'src/app/services/project.service';
import { Project } from 'src/app/shared/project';

// core components
import {
  chartOptions,
  parseOptions,
  chartExample1,
  chartExample2
} from "../../variables/charts";
import { ProjectAppService } from 'src/app/services/project-app.service';
import { ProjectApp } from 'src/app/shared/projectApp';
import { ProfileService } from 'src/app/services/profile.service';
import { Profile } from 'src/app/shared/userProfile';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  public projects: Project[] = [];
  public projectsApp: ProjectApp[] = [];
  public profile: Profile;

  //Ena zedtou !!!!
   constructor(private projectService: ProjectService, private projectAppservice: ProjectAppService, private profileService: ProfileService) {}
  ////////////

  ngOnInit() {

    //Ena zedtha !!!!
     this.listProjects();
    // this.listAppProjects();
     this.getprofile(1);
    
  }


 //Ena zedtha !!!!
   listProjects(){
    this.projectService.getProjectList().subscribe(
      data => {
        this.projects = data;
      }
    )
  }

  // listAppProjects(){
  //   this.projectAppservice.getProjectList().subscribe(
  //     data => {
  //       this.projectsApp = data;
  //     }
  //   )
  // }

  getprofile(id: number){
    this.profileService.getProfile(id).subscribe(
      data => {
        this.profile = data;
      }
    )
  }

}
