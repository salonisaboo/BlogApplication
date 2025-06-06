import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = "http://localhost:8885/api/comments";


@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  createComment(postId: number, postedBy: string, content: string): Observable<any> {
    const params= {
      postId: postId,
      postedBy: postedBy
    };

    return this.http.post(`${BASIC_URL}/create-comment`, content, {params});

  }

  getCommentsByPost(postId: number): Observable<any> {
    return this.http.get(`${BASIC_URL}/${postId}`);
  }
}
