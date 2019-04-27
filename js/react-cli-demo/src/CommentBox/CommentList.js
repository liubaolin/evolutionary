import React, {Component} from 'react';
import CommentItem from './CommentItem';


class CommentList extends Component {
    render() {
        return (
            <div className="comment-list">
                {this.props.comments.map((comment,index) => <CommentItem key={index} comment={comment}/>)}
            </div>
        );
    }
}

export default CommentList;
