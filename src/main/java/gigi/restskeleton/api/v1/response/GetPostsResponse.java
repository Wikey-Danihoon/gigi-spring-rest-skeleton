package uplus.spy.api.v1.response;

import java.util.List;

public record GetPostsResponse(List<PostResponse> posts, boolean hasNext) {}
