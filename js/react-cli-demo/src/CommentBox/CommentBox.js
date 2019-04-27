import React, {Component} from 'react';
import './CommentBox.css'
import CommentList from './CommentList';
import CommentForm from './CommentForm';

const comments = [
    {author:"Richey",content:"这真是一个不错的组件！"},
    {author:"Kelly",content:"写的不错。"}
];


class CommentBox extends Component {
    render() {
        return (
            <div className="comment-box">
                <h1>Comments</h1>
                <CommentList comments={comments}/>
                <CommentForm/>
            </div>
        );
    }
}

export default CommentBox;
