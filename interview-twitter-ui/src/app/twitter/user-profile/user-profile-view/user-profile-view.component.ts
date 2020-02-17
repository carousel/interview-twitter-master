import {Component, OnInit} from '@angular/core';
import {TweetService} from '../../../services/tweet/tweet.service';
import {Observable} from 'rxjs/Observable';
import {ActivatedRoute, Params} from '@angular/router';
import {UserProfileModel} from '../../../models/user-profile.model';

@Component({
  selector: 'app-user-profile-view',
  templateUrl: './user-profile-view.component.html',
  styleUrls: ['./user-profile-view.component.css']
})
export class UserProfileViewComponent implements OnInit {

  $profile: Observable<UserProfileModel[]>;

  constructor(private tweetService: TweetService) {
  }

  ngOnInit() {
    this.$profile = this.tweetService.userProfile();
  }

}
