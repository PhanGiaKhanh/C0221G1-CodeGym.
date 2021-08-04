import {BenhAn} from './benh-an';
import {BacSi} from './bac-si';

export interface BenhNhan {
  id?: number;
  maBenhAn?: string;
  maBenhNhan?: string;
  ten?: string;
  ngayNhapVien?: string;
  ngayRaVien?: string;
  lyDoRaVien?: string;
  benhAn?: BenhAn;
  bacSi?: BacSi;
}
