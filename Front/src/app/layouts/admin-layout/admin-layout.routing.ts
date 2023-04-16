import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
//import { IconsComponent } from '../../pages/icons/icons.component';
//import { MapsComponent } from '../../pages/maps/maps.component';
import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { TablesComponent } from '../../pages/tables/tables.component';
import { ForumComponent } from 'src/app/pages/forum/forum.component';
import { AllProjectsComponent } from 'src/app/pages/AllProjects/AllProjects.component';
import { ProjectDetailComponent } from 'src/app/ProjectDetail/ProjectDetail.component';
import { EditComponent } from 'src/app/pages/Edit/Edit.component';
import { AllFreelancersComponent } from 'src/app/pages/AllFreelancers/AllFreelancers.component';
import { FreelancerDetailComponent } from 'src/app/pages/FreelancerDetail/FreelancerDetail.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent },
    { path: 'tables',         component: TablesComponent },
   // { path: 'icons',          component: IconsComponent },
   // { path: 'maps',           component: MapsComponent },
    { path : 'forum',         component:ForumComponent},
    { path : 'all-projects'  ,   component : AllProjectsComponent},
    {path : 'project-detail/:id'  ,    component : ProjectDetailComponent},
    {path : 'edit-profile',        component: EditComponent},
    {path : 'all-freelancers',      component: AllFreelancersComponent},
    {path : 'freelancer-detail',     component: FreelancerDetailComponent}
];
