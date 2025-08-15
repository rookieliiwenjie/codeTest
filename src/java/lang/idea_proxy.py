from mitmproxy import http

def request(flow: http.HTTPFlow):
    print(f"=== 捕获到请求 ===")
    print(f"URL: {flow.request.url}")
    print(f"方法: {flow.request.method}")
    print(f"请求头: {flow.request.headers}")
    if flow.request.content:
        print(f"请求体: {flow.request.get_text()}")

def response(flow: http.HTTPFlow):
    print(f"=== 捕获到响应 ===")
    print(f"状态码: {flow.response.status_code}")
    print(f"响应头: {flow.response.headers}")
    if flow.response.content:
        print(f"响应体: {flow.response.get_text()[:500]}")  # 只显示前500字
