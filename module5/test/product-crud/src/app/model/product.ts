import {ProductType} from './product-type';

export interface Product {
  id?: number;
  name?: string;
  date?: string;
  price?: string;
  productType?: ProductType;
}
