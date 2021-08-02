import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {Product} from '../model/product';
import {ProductType} from '../model/product-type';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(API_URL + '/products');
  }

  getProductType(): Observable<ProductType[]> {
    return this.http.get<ProductType[]>(API_URL + '/productTypes');
  }

  save(product): Observable<Product> {
    return this.http.post<Product>(API_URL + '/products', product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(`${API_URL}/products/${id}`);
  }

  update(product: Product): Observable<Product> {
    return this.http.put<Product>(`${API_URL}/products/${product.id}`, product);
  }

  delete(id: number): Observable<Product> {
    return this.http.delete<Product>(`${API_URL}/products/${id}`);
  }

  search(name: string, date: string, productTypeName: string, date1: string, date2: string): Observable<Product[]> {
    return this.http.get<Product[]>(API_URL + '/products?name_like=' + name + '&date_like=' + date + '&productType.name_like=' + productTypeName + '&date_gte=' + date1 + '&date_lte=' + date2);
  }
}
