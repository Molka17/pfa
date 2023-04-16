import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProjectApp } from '../shared/projectApp';

@Injectable({
  providedIn: 'root'
})
export class ProjectAppService {

  private baseUrl = "http://localhost:8080/apply"

  constructor(private http: HttpClient){}

  getProjectList(): Observable<ProjectApp[]> {
    return this.http.get<ProjectApp[]>(`${this.baseUrl}`);
  }

  updateProject(projectId: number, projectApp: ProjectApp): Observable<ProjectApp> {
    return this.http.put<ProjectApp>(`${this.baseUrl}/update/${projectId}`, projectApp);
  }

  deleteProject(projectId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${projectId}`);
  }

  getProject(projectId : number): Observable<ProjectApp> {
    return this.http.get<ProjectApp>(`${this.baseUrl}/${projectId}`);
  }
}
