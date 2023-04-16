import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profile } from '../shared/userProfile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private baseUrl = "http://localhost:8080/profile"

  constructor(private http: HttpClient){}

  updateProfile(profileId: number, profile: Profile): Observable<Profile> {
    return this.http.put<Profile>(`${this.baseUrl}/${profileId}`, profile);
  }

  deleteProfile(profileId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${profileId}`);
  }

  getProfile(profileId : number): Observable<Profile> {
    return this.http.get<Profile>(`${this.baseUrl}/${profileId}`);
  }
}
