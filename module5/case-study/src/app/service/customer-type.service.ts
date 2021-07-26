import { Injectable } from '@angular/core';
import {CustomerType} from '../model/customer/customer-type';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  constructor(private http: HttpClient) {
  }
  getAll(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(API_URL + '/customerType');
  }
  saveCategory(customerType): Observable<CustomerType> {
    return this.http.post<CustomerType>(API_URL + '/customerType', customerType);
  }

  findById(id: number): Observable<CustomerType> {
    return this.http.get<CustomerType>(`${API_URL}/customerType/${id}`);
  }

  updateCategory(id: number, customerType: CustomerType): Observable<CustomerType> {
    return this.http.put<CustomerType>(`${API_URL}/customerType/${id}`, customerType);
  }

  deleteCategory(id: number): Observable<CustomerType> {
    return this.http.delete<CustomerType>(`${API_URL}/customerType/${id}`);
  }
}
