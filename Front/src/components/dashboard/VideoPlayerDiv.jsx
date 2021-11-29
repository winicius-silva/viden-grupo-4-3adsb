import React from "react";

export default function VideoPlayerDiv(props) {
    return (
        <>
            <div className="videoPlayer">
                <iframe src={`https://www.youtube.com/embed/${props.link}`} title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>

        </>
    )
}