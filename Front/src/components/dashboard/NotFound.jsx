import React from "react";
import imgError from "../../assets/img/box.png"

function NotFound(props) {
    return (
        <>
            <div className="cardNotFound">
                <img src={imgError} alt={'card_not_found'} className="img_cardNotFound" />
                <h4 className="descNotFound">{props.desc}</h4>
            </div>

        </>
    )
}

export default NotFound;