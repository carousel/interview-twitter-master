import {Component, Input} from '@angular/core';
import {UserProfileModel} from '../../../models/user-profile.model';

@Component({
  selector: 'app-user-profile-table',
  templateUrl: './user-profile-table.component.html',
  styleUrls: ['./user-profile-table.component.css']
})
export class UserProfileTableComponent {

  @Input() profile: UserProfileModel[];

}
