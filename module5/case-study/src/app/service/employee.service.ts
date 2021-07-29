import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../model/employee/employee';
import {environment} from '../../environments/environment';
import {Customer} from '../model/customer/customer';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL + '/employees');
  }

  getPositionList(): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL + '/positions');
  }

  getEducationDegreeList(): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL + '/educationDegrees');
  }

  getDivisionList(): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL + '/divisions');
  }
  saveEmployee(employee): Observable<Employee> {
    return this.http.post<Employee>(API_URL + '/employees', employee);
  }

  findById(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${API_URL}/employees/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${API_URL}/employees/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Employee> {
    return this.http.delete<Employee>(`${API_URL}/employees/${id}`);
  }

  search(name: string, email: string): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL + '/employees?name_like=' + name + '&email_like=' + email);
  }
}
