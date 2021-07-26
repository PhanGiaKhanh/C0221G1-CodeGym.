import {CustomerType} from './customer-type';

export interface Customer {
  id: number;
  customerType: CustomerType;
  code: string;
  name: string;
  gender: string;
  birthday: string;
  idCard: string;
  phone: string;
  email: string;
  address: string;
}
