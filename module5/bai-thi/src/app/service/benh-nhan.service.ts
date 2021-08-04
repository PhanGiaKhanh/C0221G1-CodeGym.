import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BenhNhan} from '../model/benh-nhan';
import {BenhAn} from '../model/benh-an';
import {BacSi} from '../model/bac-si';
const API_URL = 'http://localhost:3000';
@Injectable({
  providedIn: 'root'
})
export class BenhNhanService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<BenhNhan[]> {
    return this.http.get<BenhNhan[]>(API_URL + '/benhNhans');
  }

  getBenhAn(): Observable<BenhAn[]> {
    return this.http.get<BenhAn[]>(API_URL + '/benhAns');
  }
  getBacSi(): Observable<BacSi[]> {
    return this.http.get<BacSi[]>(API_URL + '/bacSis');
  }

  save(benhNhan): Observable<BenhNhan> {
    return this.http.post<BenhNhan>(API_URL + '/benhNhans', benhNhan);
  }

  findById(id: number): Observable<BenhNhan> {
    return this.http.get<BenhNhan>(`${API_URL}/benhNhans/${id}`);
  }

  update(benhNhan: BenhNhan): Observable<BenhNhan> {
    return this.http.put<BenhNhan>(`${API_URL}/benhNhans/${benhNhan.id}`, benhNhan);
  }

  delete(id: number): Observable<BenhNhan> {
    return this.http.delete<BenhNhan>(`${API_URL}/benhNhans/${id}`);
  }

}
