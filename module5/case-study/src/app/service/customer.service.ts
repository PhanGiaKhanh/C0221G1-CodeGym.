import {Injectable} from '@angular/core';
import {Customer} from '../model/customer/customer';
import {CustomerType} from '../model/customer/customer-type';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + '/customers');
  }
  getCustomerTypes(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(API_URL + '/customerType');
  }
  save(customer): Observable<Customer> {
    return this.http.post<Customer>(API_URL + '/customers', customer);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${API_URL}/customers/${id}`);
  }

  update(index: number, customer: Customer): Observable<CustomerType> {
    return this.http.put<Customer>(`${API_URL}/customers/${index}`, customer);
  }

  delete(index: number): Observable<Customer> {
    return this.http.delete<Customer>(`${API_URL}/customers/${index}`);
  }

  search(name: string, email: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + '/customers?name_like=' + name + '&email_like=' + email);
  }
  // customers: Customer[] = [
  //   {
  //     id: 1,
  //     customerType: {id: 1, name: 'Diamond'},
  //     code: 'KH-0001',
  //     name: 'Phương Nam',
  //     gender: 'Male',
  //     birthday: '2001-01-22',
  //     idCard: '123456781',
  //     phone: '0901111111',
  //     email: 'Nam1@Gmail.com',
  //     address: 'Đà Nẵng'
  //   },
  //   {
  //     id: 2,
  //     customerType: {id: 1, name: 'Diamond'},
  //     code: 'KH-0002',
  //     name: 'Bự Nam',
  //     gender: 'Female',
  //     birthday: '2002-07-12',
  //     idCard: '123456782',
  //     phone: '0902222222',
  //     email: 'Nam2@Gmail.com',
  //     address: 'Vinh'
  //   },
  //   {
  //     id: 3,
  //     customerType: {id: 2, name: 'Platinum'},
  //     code: 'KH-0003',
  //     name: 'Ròm Nam',
  //     gender: 'Male',
  //     birthday: '2001-03-16',
  //     idCard: '123456783',
  //     phone: '0903333333',
  //     email: 'Nam3@Gmail.com',
  //     address: 'Hồ Chí Minh'
  //   },
  //   {
  //     id: 5,
  //     customerType: {id: 3, name: 'Gold'},
  //     code: 'KH-0005',
  //     name: 'Nặng Nam',
  //     gender: 'Female',
  //     birthday: '2007-07-07',
  //     idCard: '123456785',
  //     phone: '0905555555',
  //     email: 'Nam5@Gmail.com',
  //     address: 'Đà Nẵng'
  //   },
  //   {
  //     id: 6,
  //     customerType: {id: 3, name: 'Gold'},
  //     code: 'KH-0006',
  //     name: 'Phì Nhiêu Nam',
  //     gender: 'Other',
  //     birthday: '2007-12-12',
  //     idCard: '123456786',
  //     phone: '0906666666',
  //     email: 'Nam6@Gmail.com',
  //     address: 'Huế'
  //   },
  //   {
  //     id: 7,
  //     customerType: {id: 4, name: 'Silver'},
  //     code: 'KH-0007',
  //     name: 'Nam',
  //     gender: 'Female',
  //     birthday: '2003-01-05',
  //     idCard: '123456787',
  //     phone: '0907777777',
  //     email: 'Nam7@Gmail.com',
  //     address: 'Hà Nội'
  //   },
  //   {
  //     id: 8,
  //     customerType: {id: 4, name: 'Silver'},
  //     code: 'KH-0008',
  //     name: 'Xinh Xắn Nam',
  //     gender: 'Male',
  //     birthday: '2005-10-28',
  //     idCard: '123456788',
  //     phone: '0908888888',
  //     email: 'Nam8@Gmail.com',
  //     address: 'Hà Nội'
  //   },
  //   {
  //     id: 9,
  //     customerType: {id: 5, name: 'Member'},
  //     code: 'KH-0009',
  //     name: 'Việt Nam',
  //     gender: 'Female',
  //     birthday: '2009-07-08',
  //     idCard: '123456789',
  //     phone: '0909999999',
  //     email: 'Nam9@Gmail.com',
  //     address: 'Đà Nẵng'
  //   },
  // ];
  //
  // constructor() {
  // }
  //
  // getAll() {
  //   return this.customers;
  // }
  //
  // saveCategory(customer) {
  //   this.customers.push(customer);
  // }
  //
  // findById(id: number) {
  //   return this.customers.find(category => category.id === id);
  // }
  //
  // updateCategory(customer: Customer) {
  //   for (let i = 0; i < this.customers.length; i++) {
  //     if (this.customers[i].id === customer.id) {
  //       this.customers[i] = customer;
  //     }
  //   }
  // }
  //
  // deleteCategory(id: number) {
  //   this.customers = this.customers.filter(category => {
  //     return category.id !== id;
  //   });
  // }
}
